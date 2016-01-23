#include <iostream>

void reverse (char * str){
 char * end = str;
 while (*end !=NULL ){
         end++;
    }
 --end;
 while (str < end){
         char tmp  = *str;
         *str  = *end;
         *end = tmp;
         end--;
         str++;
 }

}

int main(){
    char str[]  = "HELLO WOrld";
        reverse(str);
        std::cout << str;
        }
