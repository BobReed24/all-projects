import datetime
import tkinter as tk

class ChristmasCountdown:
    def __init__(self, root):
        self.root = root
        self.root.title("Christmas Countdown")

        self.label = tk.Label(root, font=("Helvetica", 24))
        self.label.pack(pady=20)

        self.christmas = datetime.datetime(year=2024, month=12, day=25, hour=0, minute=0)
        self.update_time()

    def update_time(self):
        now = datetime.datetime.now()
        time_remaining = self.christmas - now

        if time_remaining.total_seconds() > 0:
            months = (self.christmas.year - now.year) * 12 + self.christmas.month - now.month
            days = (self.christmas - (now + datetime.timedelta(days=(now.day - 1)))).days
            hours, remainder = divmod(time_remaining.seconds, 3600)
            minutes, seconds = divmod(remainder, 60)

            countdown_message = (
                f"Time until Christmas: {months} months, "
                f"{days} days, {hours} hours, "
                f"{minutes} minutes, and {seconds} seconds"
            )
            self.label.config(text=countdown_message)
        else:
            self.label.config(text="Merry Christmas!")
        
        self.root.after(1000, self.update_time) 

if __name__ == "__main__":
    root = tk.Tk()
    countdown = ChristmasCountdown(root)
    root.mainloop()
