import datetime
import time

def time_until_christmas():
    christmas = datetime.datetime(year=2024, month=12, day=25, hour=0, minute=0)

    while True:
        now = datetime.datetime.now()
        time_remaining = christmas - now
        total_seconds = int(time_remaining.total_seconds())
        
        print("\033c", end="")
        if total_seconds > 0:
            minutes, seconds = divmod(total_seconds, 60)
            print(f"Time until Christmas: {minutes} minutes and {seconds} seconds")
        else:
            print("Merry Christmas!")
            break
        
        time.sleep(1)

if __name__ == "__main__":
    time_until_christmas()
