import pprint

import requests

API_ENDPOINT_URL = "https://zenquotes.io/api"

def quote_of_the_day() -> list:
    return requests.get(API_ENDPOINT_URL + "/today", timeout=10).json()

def random_quotes() -> list:
    return requests.get(API_ENDPOINT_URL + "/random", timeout=10).json()

if __name__ == "__main__":
    
    response = random_quotes()
    pprint.pprint(response)
