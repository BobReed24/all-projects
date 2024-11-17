import os

import requests

URL_BASE = "https://www.amdoren.com/api/currency.php"

list_of_currencies = 

def convert_currency(
    from_: str = "USD", to: str = "INR", amount: float = 1.0, api_key: str = ""
) -> str:
    
    params = locals()
    
    params["from"] = params.pop("from_")
    res = requests.get(URL_BASE, params=params, timeout=10).json()
    return str(res["amount"]) if res["error"] == 0 else res["error_message"]

if __name__ == "__main__":
    TESTING = os.getenv("CI", "")
    API_KEY = os.getenv("AMDOREN_API_KEY", "")

    if not API_KEY and not TESTING:
        raise KeyError(
            "API key must be provided in the 'AMDOREN_API_KEY' environment variable."
        )

    print(
        convert_currency(
            input("Enter from currency: ").strip(),
            input("Enter to currency: ").strip(),
            float(input("Enter the amount: ").strip()),
            API_KEY,
        )
    )
