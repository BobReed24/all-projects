from datetime import UTC, date, datetime

import requests
from rich import box
from rich import console as rich_console
from rich import table as rich_table

LIMIT = 10
TODAY = datetime.now(tz=UTC)
API_URL = (
    "https://www.forbes.com/forbesapi/person/rtb/0/position/true.json"
    "?fields=personName,gender,source,countryOfCitizenship,birthDate,finalWorth"
    f"&limit={LIMIT}"
)

def years_old(birth_timestamp: int, today: date | None = None) -> int:
    
    today = today or TODAY.date()
    birth_date = datetime.fromtimestamp(birth_timestamp, tz=UTC).date()
    return (today.year - birth_date.year) - (
        (today.month, today.day) < (birth_date.month, birth_date.day)
    )

def get_forbes_real_time_billionaires() -> list[dict[str, int | str]]:
    
    response_json = requests.get(API_URL, timeout=10).json()
    return [
        {
            "Name": person["personName"],
            "Source": person["source"],
            "Country": person["countryOfCitizenship"],
            "Gender": person["gender"],
            "Worth ($)": f"{person['finalWorth'] / 1000:.1f} Billion",
            "Age": str(years_old(person["birthDate"] / 1000)),
        }
        for person in response_json["personList"]["personsLists"]
    ]

def display_billionaires(forbes_billionaires: list[dict[str, int | str]]) -> None:
    
    table = rich_table.Table(
        title=f"Forbes Top {LIMIT} Real-Time Billionaires at {TODAY:%Y-%m-%d %H:%M}",
        style="green",
        highlight=True,
        box=box.SQUARE,
    )
    for key in forbes_billionaires[0]:
        table.add_column(key)

    for billionaire in forbes_billionaires:
        table.add_row(*billionaire.values())

    rich_console.Console().print(table)

if __name__ == "__main__":
    from doctest import testmod

    testmod()
    display_billionaires(get_forbes_real_time_billionaires())
