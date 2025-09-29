#include <iostream>
#include <map>
#include <iomanip>
using namespace std;

const int PRICE_PER_ITEM = 100000;

string order_price(int quantity) {
    if (quantity <= 0) return "Lỗi: số lượng món không hợp lệ";

    double discount = 0.0;
    if (quantity <= 2) discount = 0.0;
    else if (quantity <= 5) discount = 0.1;
    else if (quantity <= 10) discount = 0.2;
    else discount = 0.3;

    double total = quantity * PRICE_PER_ITEM * (1 - discount);

    // Format số tiền đẹp hơn
    ostringstream oss;
    oss << fixed << setprecision(0) << total << " VNĐ (giảm " << discount * 100 << "%)";
    return oss.str();
}

int main() {
    // ---- Kiểm thử biên ----
    int boundary_tests[] = {-1, 0, 1, 2, 3, 5, 6, 10, 11};
    cout << "=== Kiểm thử biên ===\n";
    for (int q : boundary_tests) {
        cout << q << " món → " << order_price(q) << endl;
    }

    // ---- Kiểm thử bảng quyết định ----
    map<int, string> decision_tests = {
        {-2, "Lỗi: số lượng món không hợp lệ"},
        {1,  "100000 VNĐ (giảm 0%)"},
        {4,  "360000 VNĐ (giảm 10%)"},
        {8,  "640000 VNĐ (giảm 20%)"},
        {12, "840000 VNĐ (giảm 30%)"}
    };

    cout << "\n=== Kiểm thử bảng quyết định ===\n";
    for (auto &test : decision_tests) {
        int q = test.first;
        string expected = test.second;
        string result = order_price(q);
        cout << q << " món → " << result 
             << " (mong đợi: " << expected << ")\n";
    }

    return 0;
}
