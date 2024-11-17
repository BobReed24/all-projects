import requests

def get_ip_geolocation(ip_address: str) -> str:
    try:
        
        url = f"https://ipinfo.io/{ip_address}/json"

        response = requests.get(url, timeout=10)

        response.raise_for_status()

        data = response.json()

        if "city" in data and "region" in data and "country" in data:
            location = f"Location: {data['city']}, {data['region']}, {data['country']}"
        else:
            location = "Location data not found."

        return location
    except requests.exceptions.RequestException as e:
        
        return f"Request error: {e}"
    except ValueError as e:
        
        return f"JSON parsing error: {e}"

if __name__ == "__main__":
    
    ip_address = input("Enter an IP address: ")

    location = get_ip_geolocation(ip_address)
    print(location)
