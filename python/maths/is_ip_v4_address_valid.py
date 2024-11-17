def is_ip_v4_address_valid(ip_v4_address: str) -> bool:
    
    octets = [int(i) for i in ip_v4_address.split(".") if i.isdigit()]
    return len(octets) == 4 and all(0 <= int(octet) <= 254 for octet in octets)

if __name__ == "__main__":
    ip = input().strip()
    valid_or_invalid = "valid" if is_ip_v4_address_valid(ip) else "invalid"
    print(f"{ip} is a {valid_or_invalid} IP v4 address.")
