package com.epam.rd.contactbook;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Matcher;

public class Contact {


    private String contactName;
    public ContactInfo phoneNumber;
    public Email email;
    public Social socialMedia;
    ContactInfo[] info = new ContactInfo[10];
    private static Contact instance;
    static int countPhone = 1;
//    static int countEmails = 1;
//    static int countSocial = 4;

//    private Contact() {
//    }

    public Contact() {
    }

    public Contact(String contactName) {
        this.contactName = contactName;
        this.info = info;
    }

    public static Contact getInstance() {
        if (instance == null) {
            instance = new Contact();
        }
        return instance;
    }

    public String getName() {
        return contactName;
    }

    public ContactInfo getPhoneNumber() {

        return phoneNumber;
    }

    public Email getEmail() {
        return email;
    }

    public Social getSocialMedia() {
        return socialMedia;
    }


    private class NameContactInfo implements ContactInfo {

        @Override
        public String getTitle() {
            return "Name";
        }

        @Override
        public String getValue() {
            return contactName;
        }

        @Override
        public String toString() {
            return getTitle() + contactName;
        }

    }

    public void rename(String newName) {
        if (newName == null || newName.equals("") || newName.equals(" "))
            this.contactName = contactName;
        else
            this.contactName = newName;
    }

    public ContactInfo addPhoneNumber(int code, String number) {
        if (countPhone == 1) {
            countPhone++;
            ContactInfo phone = new ContactInfo() {

                String phone;

                @Override
                public String getTitle() {
                    return "Tel";
                }

                @Override
                public String getValue() {
                    return phone = "+" + code + " " + number;
                }

                @Override
                public String toString() {
                    return getTitle() + getValue();
                }
            };

            info[1] = phone;
            phoneNumber = phone;
            return phoneNumber;
        }
        return null;
    }


    public static class Email implements ContactInfo {
        public static final int Maximun = 3;
        public String localPart;
        public String domain;
        static final String domainEpam = "epam.com";

        public Email() {

        }

        public void setLocalPart(String localPart) {
            this.localPart = localPart;
        }

        public void setDomain(String domain) {
            this.domain = domain;
        }

        public Email(String localPart, String domain) {
            this.localPart = localPart;
            this.domain = domain;

        }


        @Override
        public String getTitle() {
            return "Email";
        }

        @Override
        public String getValue() {
            String email = this.localPart + "@" + this.domain;
            return email;
        }

        @Override
        public String toString() {
            return getTitle() + getValue();
        }
    }

    public Email addEmail(String localPart, String domain) {



        if (localPart == null || domain == null)
            return null;
        else {
//            Email.create();
            email = new Email(localPart, domain);
            //    Email.countEmail++;
            for (int i = 2; i < 5; i++) {
                info[i] = email;
            }
            return email;
        }
    }


    public Email addEpamEmail(String firstname, String lastname) {

        ContactInfo emailEpm = new Contact.Email() {

            @Override
            public String getTitle() {
                return "Epam Email";
            }

            @Override
            public String getValue() {
                String localPart = firstname + "_" + lastname + "@";
                return localPart + Email.domainEpam;
            }

            @Override
            public String toString() {
                return getTitle() + getValue();
            }
        };

        for (int i = 2; i < 5; i++) {
            info[i] = emailEpm;
            email = (Email) emailEpm;
        }
        return email;

    }


    public static class Social implements ContactInfo {

        String socialName;
        String id;

        public Social() {
            this.socialName = getTitle();
            this.id = getValue();
        }

        @Override
        public String getTitle() {
            return "Social :";
        }

        @Override
        public String getValue() {
            return socialName;
        }

        @Override
        public String toString() {
            return getTitle() + getValue();
        }
    }

    public Social addTwitter(String twitterId) {

        ContactInfo social = new Contact.Social() {
            @Override
            public String getTitle() {
                return "Twitter";
            }

            @Override
            public String getValue() {
                return twitterId;
            }
        };

        for (int i = 5; i < 10; i++) {
            info[i] = social;
            socialMedia = (Social) social;
        }
        return socialMedia;

    }

    public Social addInstagram(String instagramId) {

        ContactInfo social = new Contact.Social() {
            @Override
            public String getTitle() {
                return "Instagram";
            }

            @Override
            public String getValue() {
                return instagramId;
            }
        };

        for (int i = 5; i < 10; i++) {
            info[i] = social;
            socialMedia = (Social) social;
        }
        return socialMedia;
    }


    public Social addSocialMedia(String title, String id) {

        ContactInfo social = new Contact.Social() {
            @Override
            public String getTitle() {
                return title;
            }

            @Override
            public String getValue() {
                return id;
            }
        };

        for (int i = 5; i < 10; i++) {
            info[i] = social;
            socialMedia = (Social) social;
        }
        return socialMedia;

    }


    public ContactInfo[] getInfo() {

        info[0] = new Contact.NameContactInfo();

        ContactInfo[] arr = new ContactInfo[info.length];
        int count = -1;
        for (ContactInfo el : info) {
            if (el != null) {
                arr[++count] = el;
            }
        }
        info = Arrays.copyOf(arr, count + 1);

        return info;
    }
}


