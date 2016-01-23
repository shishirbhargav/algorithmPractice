#include <iostream>
using namespace std;

void anagram(char * s, char * t){
        std::string string_s(s);
        std::string string_t(t);
        std::sort(string_s.begin(),string_s.end());

std::sort(string_t.begin(),string_t.end());

    if (string_s.compare(string_t) == 0){
           std::cout << s << "'s anagram is " << t << endl;
               return;
    }
           std::cout << s << " is not anagram of " << t << endl;
}
int main(){
        char * str1 = "iceman";
        char * str2 = "cinema";
        anagram(str1,str2);
        str1 = "icema";
        str2 = "cinema";
        anagram(str1,str2);
}
