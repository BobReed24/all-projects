#include <iostream>
#include <string>
#include <cstdlib>
#include <ctime>
#include <random>

using namespace std;

char generateRandomChar(const string& charSet) {
    return charSet[rand() % charSet.length()];
}

string generateSimpleAIInspiredPassword(const string& name, const string& favoriteColor, int favoriteNumber) {
    string charSetUpper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    string charSetLower = "abcdefghijklmnopqrstuvwxyz";
    string digits = "0123456789";
    
    string password = "";

    password += name.substr(0, 1);
    password += favoriteColor.substr(0, 1);
    password += to_string(favoriteNumber % 10);

    password += generateRandomChar(charSetUpper);
    password += generateRandomChar(charSetLower);
    password += generateRandomChar(digits);

    return password;
}

int main() {
    srand(time(0));

    string name, favoriteColor;
    int favoriteNumber;

    cout << "Enter your full name: ";
    getline(cin, name);

    cout << "Enter your favorite color: ";
    getline(cin, favoriteColor);

    cout << "Enter your favorite number: ";
    cin >> favoriteNumber;

    string password = generateSimpleAIInspiredPassword(name, favoriteColor, favoriteNumber);

    cout << "Your simple, yet secure password is: " << password << endl;

    return 0;
}
