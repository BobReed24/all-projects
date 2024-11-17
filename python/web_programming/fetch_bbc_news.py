import requests

_NEWS_API = "https://newsapi.org/v1/articles?source=bbc-news&sortBy=top&apiKey="

def fetch_bbc_news(bbc_news_api_key: str) -> None:
    
    bbc_news_page = requests.get(_NEWS_API + bbc_news_api_key, timeout=10).json()
    
    for i, article in enumerate(bbc_news_page["articles"], 1):
        print(f"{i}.) {article['title']}")

if __name__ == "__main__":
    fetch_bbc_news(bbc_news_api_key="<Your BBC News API key goes here>")
