def join(separator: str, separated: list[str]) -> str:
    
    joined = ""
    for word_or_phrase in separated:
        if not isinstance(word_or_phrase, str):
            raise Exception("join() accepts only strings")
        joined += word_or_phrase + separator

    return joined.strip(separator)

if __name__ == "__main__":
    from doctest import testmod

    testmod()
