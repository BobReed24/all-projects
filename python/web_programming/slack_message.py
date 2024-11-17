import requests

def send_slack_message(message_body: str, slack_url: str) -> None:
    headers = {"Content-Type": "application/json"}
    response = requests.post(
        slack_url, json={"text": message_body}, headers=headers, timeout=10
    )
    if response.status_code != 200:
        msg = (
            "Request to slack returned an error "
            f"{response.status_code}, the response is:\n{response.text}"
        )
        raise ValueError(msg)

if __name__ == "__main__":
    
    send_slack_message("<YOUR MESSAGE BODY>", "<SLACK CHANNEL URL>")
