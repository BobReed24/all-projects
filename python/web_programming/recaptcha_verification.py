import requests

try:
    from django.contrib.auth import authenticate, login
    from django.shortcuts import redirect, render
except ImportError:
    authenticate = login = render = redirect = print

def login_using_recaptcha(request):
    
    secret_key = "secretKey"  
    url = "https://www.google.com/recaptcha/api/siteverify"

    if request.method != "POST":
        return render(request, "login.html")

    username = request.POST.get("username")
    password = request.POST.get("password")
    client_key = request.POST.get("g-recaptcha-response")

    response = requests.post(
        url, data={"secret": secret_key, "response": client_key}, timeout=10
    )
    
    if response.json().get("success", False):
        
        user_in_database = authenticate(request, username=username, password=password)
        if user_in_database:
            login(request, user_in_database)
            return redirect("/your-webpage")
    return render(request, "login.html")
