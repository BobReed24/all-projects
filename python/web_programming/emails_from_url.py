from __future__ import annotations

__author__ = "Muhammad Umer Farooq"
__license__ = "MIT"
__version__ = "1.0.0"
__maintainer__ = "Muhammad Umer Farooq"
__email__ = "contact@muhammadumerfarooq.me"
__status__ = "Alpha"

import re
from html.parser import HTMLParser
from urllib import parse

import requests

class Parser(HTMLParser):
    def __init__(self, domain: str) -> None:
        super().__init__()
        self.urls: list[str] = []
        self.domain = domain

    def handle_starttag(self, tag: str, attrs: list[tuple[str, str | None]]) -> None:
        
        if tag == "a":
            
            for name, value in attrs:
                
                if name == "href" and value not in (*self.urls, "", "
                    url = parse.urljoin(self.domain, value)
                    self.urls.append(url)

def get_domain_name(url: str) -> str:
    
    return ".".join(get_sub_domain_name(url).split(".")[-2:])

def get_sub_domain_name(url: str) -> str:
    
    return parse.urlparse(url).netloc

def emails_from_url(url: str = "https://github.com") -> list[str]:
    
    domain = get_domain_name(url)

    parser = Parser(domain)

    try:
        
        r = requests.get(url, timeout=10)

        parser.feed(r.text)

        valid_emails = set()
        for link in parser.urls:
            
            try:
                read = requests.get(link, timeout=10)
                
                emails = re.findall("[a-zA-Z0-9]+@" + domain, read.text)
                
                for email in emails:
                    valid_emails.add(email)
            except ValueError:
                pass
    except ValueError:
        raise SystemExit(1)

    return sorted(valid_emails)

if __name__ == "__main__":
    emails = emails_from_url("https://github.com")
    print(f"{len(emails)} emails found:")
    print("\n".join(sorted(emails)))
