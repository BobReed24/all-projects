import random
import sys

from maths.greatest_common_divisor import gcd_by_iterative

from . import cryptomath_module as cryptomath

SYMBOLS = (
    rabcdefghijklmnopqrstuvwxyz{|}~
    >>> encrypt_message(4545, 'The affine cipher is a type of monoalphabetic '
    ...                       'substitution cipher.')
    'VL}p MM{I}p~{HL}Gp{vp pFsH}pxMpyxIx JHL O}F{~pvuOvF{FuF{xIp~{HL}Gi'
    
    >>> decrypt_message(4545, 'VL}p MM{I}p~{HL}Gp{vp pFsH}pxMpyxIx JHL O}F{~pvuOvF{FuF'
    ...                       '{xIp~{HL}Gi')
    'The affine cipher is a type of monoalphabetic substitution cipher.'
    
    >>> key = get_random_key()
    >>> msg = "This is a test!"
    >>> decrypt_message(key, encrypt_message(key, msg)) == msg
    True
    """
    message = input("Enter message: ").strip()
    key = int(input("Enter key [2000 - 9000]: ").strip())
    mode = input("Encrypt/Decrypt [E/D]: ").strip().lower()

    if mode.startswith("e"):
        mode = "encrypt"
        translated = encrypt_message(key, message)
    elif mode.startswith("d"):
        mode = "decrypt"
        translated = decrypt_message(key, message)
    print(f"\n{mode.title()}ed text: \n{translated}")

if __name__ == "__main__":
    import doctest

    doctest.testmod()
    
