from urllib.error import HTTPError

from bs4 import BeautifulSoup
from requests import exceptions, get

BASE_URL = "https://www.wellrx.com/prescriptions/{0}/{1}/?freshSearch=true"

def fetch_pharmacy_and_price_list(drug_name: str, zip_code: str) -> list | None:
    
    try:
        
        if not drug_name or not zip_code:
            return None

        request_url = BASE_URL.format(drug_name, zip_code)
        response = get(request_url, timeout=10)

        response.raise_for_status()

        soup = BeautifulSoup(response.text, "html.parser")

        pharmacy_price_list = []

        grid_list = soup.find_all("div", {"class": "grid-x pharmCard"})
        if grid_list and len(grid_list) > 0:
            for grid in grid_list:
                
                pharmacy_name = grid.find("p", {"class": "list-title"}).text

                price = grid.find("span", {"p", "price price-large"}).text

                pharmacy_price_list.append(
                    {
                        "pharmacy_name": pharmacy_name,
                        "price": price,
                    }
                )

        return pharmacy_price_list

    except (HTTPError, exceptions.RequestException, ValueError):
        return None

if __name__ == "__main__":
    
    drug_name = input("Enter drug name: ").strip()
    zip_code = input("Enter zip code: ").strip()

    pharmacy_price_list: list | None = fetch_pharmacy_and_price_list(
        drug_name, zip_code
    )

    if pharmacy_price_list:
        print(f"\nSearch results for {drug_name} at location {zip_code}:")
        for pharmacy_price in pharmacy_price_list:
            name = pharmacy_price["pharmacy_name"]
            price = pharmacy_price["price"]

            print(f"Pharmacy: {name} Price: {price}")
    else:
        print(f"No results found for {drug_name}")
