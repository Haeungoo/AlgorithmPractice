package com.haeuni.cando.week4;
import java.util.Arrays;

// 프로그래머스 - 전화번호 목록
public class Hash_Step2 {
    public boolean solution(String[] phone_book) {
        Arrays.sort(phone_book);
        for(int i = 0; i < phone_book.length - 1; i++){
            if(phone_book[i+1].startsWith(phone_book[i])){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args){
        String[] phone_book1 = {"119","97674223","1195524421"};
        String[] phone_book2 = {"123","456","789"};
        String[] phone_book3 = {"12","123","1235","567","88"};
        Hash_Step2 hash_step2= new Hash_Step2();
        System.out.println(hash_step2.solution(phone_book1));
        System.out.println(hash_step2.solution(phone_book2));
        System.out.println(hash_step2.solution(phone_book3));
    }

}
