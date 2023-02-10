package com.epam.rd.contactbook;

import java.util.Arrays;

public class main {
    public static void main(String[] args) {
//        Contact contact = new Contact("William the Conqueror");
//
//        ContactInfo tel1 = contact.addPhoneNumber(33, "276-1066-555");
//        ContactInfo tel2 = contact.addPhoneNumber(44, "20-1066-5555");
//        ContactInfo tel3 = contact.addPhoneNumber(33, "55-1066-5555");
//
//        ContactInfo[] info = contact.getInfo();
//
//        System.out.println(tel1);
//        System.out.println(tel2);
////        for(ContactInfo el:info){
////            System.out.println(el);
////        }


        Contact contact = new Contact("William the Conqueror");

        contact.addEmail("william", "normandy.fr");
        contact.addEmail("william", "england.travel");

        contact.addEpamEmail("william", "conqueror");

        contact.addTwitter("@william1066");
        contact.addInstagram("@bayeux_tapestry");
        contact.addSocialMedia("Facebook", "la_manche_tours");

        contact.addPhoneNumber(44, "20-1066-1087");

        ContactInfo[] info = contact.getInfo();
    }
}
