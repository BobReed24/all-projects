// Only works on windows systems
#include <windows.h>
#include <string>
#include <sstream>
#include <ctime>

LRESULT CALLBACK WindowProc(HWND hwnd, UINT uMsg, WPARAM wParam, LPARAM lParam);

std::wstring GetChristmasCountdown() {
    SYSTEMTIME systemTime;
    GetLocalTime(&systemTime);

    tm current = { 0 };
    current.tm_year = systemTime.wYear - 1900;
    current.tm_mon = systemTime.wMonth - 1;
    current.tm_mday = systemTime.wDay;
    current.tm_hour = systemTime.wHour;
    current.tm_min = systemTime.wMinute;
    current.tm_sec = systemTime.wSecond;

    tm christmas = { 0 };
    christmas.tm_year = current.tm_year;
    christmas.tm_mon = 11;
    christmas.tm_mday = 25;

    time_t currentTime = mktime(&current);
    time_t christmasTime = mktime(&christmas);

    if (difftime(christmasTime, currentTime) < 0) {
        christmas.tm_year += 1;
        christmasTime = mktime(&christmas);
    }

    double secondsRemaining = difftime(christmasTime, currentTime);
    int days = static_cast<int>(secondsRemaining / 86400);
    secondsRemaining -= days * 86400;
    int hours = static_cast<int>(secondsRemaining / 3600);
    secondsRemaining -= hours * 3600;
    int minutes = static_cast<int>(secondsRemaining / 60);
    int seconds = static_cast<int>(secondsRemaining) % 60;

    std::wstringstream countdown;
    countdown << L"Countdown to Christmas:\n"
              << days << L" days, "
              << hours << L" hours, "
              << minutes << L" minutes, "
              << seconds << L" seconds";

    return countdown.str();
}

int WINAPI WinMain(HINSTANCE hInstance, HINSTANCE hPrevInstance, LPSTR lpCmdLine, int nCmdShow) {
    const wchar_t CLASS_NAME[] = L"ChristmasCountdown";

    WNDCLASSW wc = {};
    wc.lpfnWndProc = WindowProc;
    wc.hInstance = hInstance;
    wc.lpszClassName = CLASS_NAME;
    wc.hbrBackground = (HBRUSH)(COLOR_WINDOW + 1);

    RegisterClassW(&wc);

    HWND hwnd = CreateWindowExW(
        0,
        CLASS_NAME,
        L"Christmas Countdown",
        WS_OVERLAPPEDWINDOW,
        CW_USEDEFAULT, CW_USEDEFAULT, 400, 200,
        NULL, NULL, hInstance, NULL
    );

    if (!hwnd) {
        return 0;
    }

    ShowWindow(hwnd, nCmdShow);

    MSG msg = {};
    while (GetMessage(&msg, NULL, 0, 0)) {
        TranslateMessage(&msg);
        DispatchMessage(&msg);
    }

    return 0;
}

LRESULT CALLBACK WindowProc(HWND hwnd, UINT uMsg, WPARAM wParam, LPARAM lParam) {
    static std::wstring countdownText;

    switch (uMsg) {
    case WM_CREATE:
        SetTimer(hwnd, 1, 1000, NULL);
        return 0;

    case WM_TIMER:
        countdownText = GetChristmasCountdown();
        InvalidateRect(hwnd, NULL, TRUE);
        return 0;

    case WM_PAINT: {
        PAINTSTRUCT ps;
        HDC hdc = BeginPaint(hwnd, &ps);

        RECT rect;
        GetClientRect(hwnd, &rect);

        DrawTextW(hdc, countdownText.c_str(), -1, &rect, DT_CENTER | DT_VCENTER | DT_WORDBREAK);

        EndPaint(hwnd, &ps);
        return 0;
    }

    case WM_DESTROY:
        PostQuitMessage(0);
        return 0;
    }

    return DefWindowProcW(hwnd, uMsg, wParam, lParam);
}
