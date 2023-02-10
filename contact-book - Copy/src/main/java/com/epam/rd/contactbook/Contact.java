package com.epam.rd.contactbook;

import java.util.Arrays;

public class Contact {


    private String contactName;
    public ContactInfo phoneNumber;
    public Email email;
    public Social socialMedia;
    ContactInfo[] info = new ContactInfo[10];
    static int countPhone = 1;
    static int countEmails = 1;
    static int countSocial = 4;

    public Contact() {
    }

    public Contact(String contactName) {

        this.contactName = contactName;
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


    public static class Email implements ContactInfo {
        public String localPart;
        public String domain;
        static final String domainEpam = "epam.com";

        public Email() {
            countEmails++;
        }

        public Email(String localPart, String domain) {
            countEmails++;
            this.localPart = localPart;
            this.domain = domain;
        }


        public Email(String localPart) {
            this(localPart, domainEpam);
            countEmails++;

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

    public static class Social implements ContactInfo {

        String socialName;

        public Social() {
            countSocial++;
            this.socialName = getTitle();
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


    public void rename(String newName) {
        if (newName == null || newName.equals("") || newName.equals(" "))
            this.contactName = contactName;
        else
            this.contactName = newName;
    }


    public Email addEmail(String localPart, String domain) {
        if (countEmails < 4) {
            if (localPart == null || domain == null)
                return null;
            else {
                email = new Email(localPart, domain);
                info[countEmails] = email;
                return email;
            }
        } else
            return null;

    }


    public Email addEpamEmail(String firstname, String lastname) {
        if (countEmails < 4) {
            ContactInfo emailEpm = new Email() {
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
            info[countEmails] = emailEpm;
            email= (Email) emailEpm;
            return email;
        } else
            return null;
    }

    public ContactInfo addPhoneNumber(int code, String number) {
        if (countPhone == 1) {

            ContactInfo phone = new ContactInfo() {
                @Override
                public String getTitle() {
                    return "Tel";
                }

                @Override
                public String getValue() {
                    String phone = "+" + code + " " + number;
                    return phone;
                }

                @Override
                public String toString() {
                    return getTitle() + getValue();
                }
            };
            countPhone++;
            info[1] = phone;
            phoneNumber=phone;
            return phoneNumber;
        } else
            return null;
    }

    public Social addTwitter(String twitterId) {
        if (countSocial < 9) {
            ContactInfo social = new Social() {
                @Override
                public String getTitle() {
                    return "Twitter";
                }

                @Override
                public String getValue() {
                    return twitterId;
                }
            };

            info[countSocial] = social;
            return socialMedia;
        } else
            return null;
    }

    public Social addInstagram(String instagramId) {
        if (countSocial < 9) {
            ContactInfo social = new Social() {
                @Override
                public String getTitle() {
                    return "Instagram";
                }

                @Override
                public String getValue() {
                    return instagramId;
                }
            };

            info[countSocial] = social;
            return socialMedia;
        } else
            return null;
    }


    public Social addSocialMedia(String title, String id) {
        if (countSocial < 9) {
            ContactInfo social = new Social() {
                @Override
                public String getTitle() {
                    return title;
                }

                @Override
                public String getValue() {
                    return id;
                }
            };

            info[countSocial] = social;
            return socialMedia;
        } else
            return null;
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


