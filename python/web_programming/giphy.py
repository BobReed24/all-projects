import requests

giphy_api_key = "YOUR API KEY"

def get_gifs(query: str, api_key: str = giphy_api_key) -> list:
    
    formatted_query = "+".join(query.split())
    url = f"https://api.giphy.com/v1/gifs/search?q={formatted_query}&api_key={api_key}"
    gifs = requests.get(url, timeout=10).json()["data"]
    return [gif["url"] for gif in gifs]

if __name__ == "__main__":
    print("\n".join(get_gifs("space ship")))
