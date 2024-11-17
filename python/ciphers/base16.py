def base16_encode(data: bytes) -> str:
    
    return "".join([hex(byte)[2:].zfill(2).upper() for byte in list(data)])

def base16_decode(data: str) -> bytes:
    
    if (len(data) % 2) != 0:
        raise ValueError(
            
        )
    
    if not set(data) <= set("0123456789ABCDEF"):
        raise ValueError(
            
        )
    
    return bytes(int(data[i] + data[i + 1], 16) for i in range(0, len(data), 2))

if __name__ == "__main__":
    import doctest

    doctest.testmod()
