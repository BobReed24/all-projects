#include <iostream>
#include <chrono>
#include <thread>
#include <iomanip>
#include <string>
#include <ctime>
#include <sstream>
#include <SFML/Graphics.hpp>

class ChristmasCountdown {
public:
    ChristmasCountdown() {
        window.create(sf::VideoMode(800, 600), "Christmas Countdown");
        font.loadFromFile("Helvetica.ttf");
        text.setFont(font);
        text.setCharacterSize(24);
        text.setPosition(50, 250);
        christmas = std::chrono::system_clock::from_time_t(std::mktime(&setChristmasDate()));
        update_time();
    }

    void run() {
        while (window.isOpen()) {
            sf::Event event;
            while (window.pollEvent(event)) {
                if (event.type == sf::Event::Closed)
                    window.close();
            }
            window.clear();
            window.draw(text);
            window.display();
            std::this_thread::sleep_for(std::chrono::seconds(1));
            update_time();
        }
    }

private:
    sf::RenderWindow window;
    sf::Font font;
    sf::Text text;
    std::chrono::system_clock::time_point christmas;

    std::tm setChristmasDate() {
        std::tm tm = {};
        tm.tm_year = 2024 - 1900;
        tm.tm_mon = 11; 
        tm.tm_mday = 25; 
        tm.tm_hour = 0;
        tm.tm_min = 0;
        tm.tm_sec = 0;
        return tm;
    }

    void update_time() {
        auto now = std::chrono::system_clock::now();
        auto time_remaining = std::chrono::duration_cast<std::chrono::seconds>(christmas - now).count();

        if (time_remaining > 0) {
            int months = (2024 - 2023) * 12 + 12 - (now_time().tm_mon + 1);
            int days = (time_remaining / (24 * 3600));
            int hours = (time_remaining % (24 * 3600)) / 3600;
            int minutes = (time_remaining % 3600) / 60;
            int seconds = time_remaining % 60;

            std::ostringstream countdown_message;
            countdown_message << "Time until Christmas: " << months << " months, "
                              << days << " days, " << hours << " hours, "
                              << minutes << " minutes, and " << seconds << " seconds";
            text.setString(countdown_message.str());
        } else {
            text.setString("Merry Christmas!");
        }
    }

    std::tm now_time() {
        std::time_t t = std::chrono::system_clock::to_time_t(std::chrono::system_clock::now());
        return *std::localtime(&t);
    }
};

int main() {
    ChristmasCountdown countdown;
    countdown.run();
    return 0;
}
