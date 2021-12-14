package com.example.td5;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class ContactActivity extends AppCompatActivity {

    List<Contact> contacts = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_contact);

        // Lookup the recyclerview in activity layout
        RecyclerView rvContacts = (RecyclerView) findViewById(R.id.rvContacts);
        int cpt = 0;
        // initialisation des contacts
        do {
            cpt ++;
            contacts.add(new Contact("Poutine", "Vladimir", "data:image/jpeg;base64,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"));
            contacts.add(new Contact("Labidi", "Nouhaila", "data:image/jpeg;base64,/9j/4AAQSkZJRgABAQAAAQABAAD/2wCEAAoHCBUVFRgVFRUVGBgaGBgYGBgaGBIYEhgYGBgZGRgYGBgcIS4lHB4rIRgYJjgmKy8xNTU1GiQ7QDs0Py40NTEBDAwMEA8QGhISGDEdGCExMTQ0MTExNDExNDExMTQxNDQxNDQxNDQ0ND80PzE0NDE0NDQxMTQ0NDE0MTE0MTExMf/AABEIANcA6gMBIgACEQEDEQH/xAAcAAAABwEBAAAAAAAAAAAAAAAAAQIDBAUGBwj/xAA7EAACAQIEBAMHAgQFBQEAAAABAgADEQQFITEGEkFRYXGBBxMiMpGhscHRI1Lh8DNCYnLxFUOSssIU/8QAGQEAAwEBAQAAAAAAAAAAAAAAAAECAwQF/8QAHxEBAQEBAAIDAQEBAAAAAAAAAAECEQMxEiFBImFR/9oADAMBAAIRAxEAPwDrsOJEMCWQQ4ILRAILQ7QWgBWgtDtBaAFaIdwoJOgG8axmKWmhZj5eJnKeOOJ3c8gYgC91H694dOZ60vEHG9OldafIza+I85gsbxjiXJPvLX6DTT0mTxOIZjI3NJV2f8aN8+xB/wC6/wD5MPxINbEMxuxJPcm5+sq1cx1apgOw67HpELVIigAfCE6EeMXRcn6OYOuzEeRI/EtcHxJiaeqV6g8C7EfQmUCiKZz29Y5aTouU+0rEIwFYLUTrpyvbwI0v5zpWScSYbFD+E4LdUbRx6TzdznxkjDYplIKkgi1iCQQfAiPpceogIJyPhf2i1EsmJ/iJtzj/ABF8x/mH3851PBY1KqB6bqynYg3ECsSDBBBGAiDFxMATCMMiEYFCTCtFQoKLghiCMgEOCARAIIdoLQAoRh2kXMsalGm9RzZVFz+3rtAozfGOYKgAJ+UXPmf6TiWaYou7t3Jl1xDnj4l3dtAx0UXsB0mcqaxda8+jBaIMfSkTHqeBduhk9gmLUICBhLZ8rZRzESI1K3TSL5QXGojK8mpUBEivStEDSP6pduUt0BjW3j4/nSIStY7x1dfrD0fs2bRN441MeR+0aa+xjKw/Rr2ml4Y4qq4RwyG6E/Gh2Yd/A+MyQkhNYE9J5HnFPFU1qU2BB3GnMp6gyznnXhnP6mDrB1N1uOdOjDt/Wd7yfM0xNJatM3Vht1B6giUnifERcK0ATCirRJEAKFFQrRgoQ4IYgBwQQRAIIIIARM5l7Us4b4cMpFtGe1736AzccR5uuGoNUNibWQfzMRoPKcGzXGvUdnZiSxuT4mCsz9QagjmGwZfuYvDU+Y66zT5VgxppaZb1xvjPTOAycWuwMtFwKqNpPSnF8k57eunOeKivhRa0y+Mw2pFuv2m5q0pQZrhbHmEM65VXMrLsl5Dq0rGXFajIlWneb505t4VhSBbiSCtjC0lxh8R0ao2Oxjz0hbuPvI/J2ijUK2HSAls9ktSA2MNNDrCd/wDmI975RleHrzWcDcUNhKoVv8NyA410H8w8tPSY3mvFJU1j6mvUlCqrqGU3BFwehB2MdnN/ZZxEaiHDO3xIOamTuUvqPG17zo6xkIiCKiTAEkQQ7Q+WAACKiQIqACCACC0AEEFoziq6ojOxsFBJ8hARzD2o5vzVFw67UwWbxdrW+g/M5w2ptLPO8aatZ3bdnYjyvoPpIuFw5ZpNvGmZ+LTJsFc3tNXhqVpDyrD2US1RZy6va7MTkKCRXLFoskJSvJ40iE1KV+PwvMJfmlI9agIcNha+G12lVjKPKfxNnmGD0vKDG0LqT2/SXnSNZ6zlRYwRaTKqWjDqDNs1y6yaUwHWHyxQWWzpHJpaINHtv9o+2kYdrHSCaZBsYfNeGzAxAMErjIcxehWSqhIZDzeY6g+YvPRWUZgmIpJVT5WAPl3B9RPMVJ51f2U56AThWPzEunmPmA+l/SUHVYRgEBgBQQCHaAHAIIIAoQoBDiBJMynHWYe7pBb6MGuO+2nlNUTOR+0rOOeoqLflW4v37wqsz7YWub385oMkw9xqvrKLDJzOF8Zv8swvIgmWq38c+z1KnYWj6wARaWmLqh2msmU1jNEAyaixSH2EckbqJJfJCKx8HVRiMNfS0zuZYIo3Nb4f3m0enI+IwoYEEbyeH1zjH4DmHMo85SVcMR0nRMZlJTVBcduo9ZSYnLw17DWVnVlTrMrHBf77RVpYYjAka6jvI60b6dZvNSubXjsRiNJFqKR4iTK9ErI/OesqXrHWbEYC8ICOOnaNX+saODUyzyfHtRqpUQ/EjAj0t/frKu8cRtY4T1BlOPSvSp1UIKuoPkeo9DcSbOZ+yTOgyPhmNmBLp4g/MP19Z0yMCtDgggAggggVKvCvAIURouZVuSmzWvpb6/8AM4HxVVvXIB0UkTuXEFS1PwJF/LU/pPPub1C1Vjf/ADE/eKtM/US+H0566D1nSOW0wHB1O9ZT4ToDCY7rfx+lbiMWbkKNvzEIrNe9xLCnhlBuRcyR7xQOkjrfnVC9V0+Vmh/9WrDUE+o3ly3If5YwaKHt9odpcKy/PHYfENRLmjXDi8oxQUbCTcDppeK1UWd4ljCBjdZ7RGZxlUKNdZlM3xn8q69/3lxjDc7yA2CVvWPqWYr13Y3I3+kivRY62J8ptkylLai8fXLUAtbSV8k2MBVw721H7ypq0iDYzqFTLqYGgmW4hy5VIKdb6fePOvxOsd+2TI6G0Zqp1kiqtmIjbjSbxy6nDAMWrQuWBrDaDPrScJY1qNdKqXupuw7razA+hM9C4PErURXQ3VgGB8DPOXClZRWVX2a4+oM7rwu5FIITcLoPDt6Ea/WM7xfQQQRkEAgggComAwRFGa43rlKII7n/ANTOKUaCO7F7kX0t3nU/aPjSFCDa1/MnSctwrfPfuD9zI1rjp8U/6uOFkAradFP5m2JmL4W/xj/t/WbYTHVb5iDia5WZzE5i5fkpqXcmwBNlE1OJw3NKirk92uLqe4veRLyrvpnc1xWLpsytUVLJz2XlAPgCRcmTOHsViarBeZGuvOL8u3Yldjp18JaYrJveWLtzEC1zvbtJOW5QtG5QkEi1xvNPlPSPj+9Lw1cluRgVYbg/TTuJY0WsZHbBhmDlmuNrkm3hJAWRWkWNJ9JCx9SO0jpI2O2iVxWvV1iKmKC2ubX7asfBQNzEODfSIw+EZX95zAt0uA3L5DpCe02IObZ09LmtSf4bcxY2tzbXA2vI9HPqjnlNFwQLkKx5rd7GT87yp8QxYsAWA5gLgG2xI7xjB5bWokspBYjlDNckC3SXLll8dd9ipZzc2DE9wQQw84jH1ufl85HfL2Llm1J3I0kpsKQAe0jVnfprmXn2yeaUOV5DZZf52gJBlIw3m+ddjk8meaRW084h16x2qNYRE0Y0eGqFGDDcEH6TvXAObrXp6b2HMOx2nAJtuAMxqJWQIGI51DAdVLC4h1LvIgtADFRgmCERDjARnFVeRGbsI7eRM0cCm9+1vU7RCOY8c49XqC3QXt42mDwz/GF76esveIat3didvhExz1CGuDqDf1md++t5r48bfhy61x4gibZJi8hqA8j9/wAzZoZjXV/sO8sP3cUgjoWSviO1MdoXJJXJByRj4o/u4y41k11kBjrEDtOMYzaPoIziVuIGrQkkJTvGusmUFgmiWn4RZoiSUSHyRWiZV1TDL2kWrRltUEg1hDh+mJ4jTl+sojb6iafitfgJ7EfmZFH0m/j9ObzX+jdZdoTrF4g6A+MDNdbeWvlNXNfZphpNn7PqTDEI4HMvvEV9/hBIPN9vvMeouJ132RYEhKjsujBAD0NiYCOmCHeEsO8aRQRMVGBSh4mxQVbX2BY+g0/Mv5heMH1qa9LHyAH7xX0rM65nnD8ysx3JvbxmWdpf57U2HckzPGRFbbDgrE816Z3WzDym/pNOTcM48UqwLbMOUntfW86jhaoYAg3H1mW88dPh13KyptJSCQaTSYjSHRD1okwi0aqPEaPiatzpI4XrHHSMvUYaAD6wJNw9O8LEUvhkajXIMPEYz4TGFfWXWIp1yphGoSYpqXMIuhc4WoCJJZZVYEkaGWHvNISg1WldXaTKzyvxD7wDJcY1bUyO5EyFFtJf8ZVblF8zM5TM6MT+XD5r/Rx2uItDpI8dpmWxSMGnMyr3Np3n2dIVwaqd1d1v3sdJwbCmzqexH5noDgtv4TrrpUuO1nRGFvqY4d9NJChgQ4JNiKiIq8YAznfGT6VPFwPS86GZzjjAAuVvu5J8kUX+8nS8e3Mc8N3bsNBKRpZZlUuSf5iT95WkaxZGvYrzpnBj3wyeBYfQmczm+4BxF6bp1Vr+jD+hi3PpXhv9NojSQjyMgjizmtd+UlqkQWiAZTZnmPI6rstrsfxBXV0xvGykraWaIw0N5KXFA9IfEvZx6YjL0BaGcV4Rt8YOgvD4g0KVpIpLIb40DfSM/wDVkG7AecOUqubW1hmppK/A5gr3AN/HpJFoqIKq8gV3kurIlcaRfoYPi1/jXyP5lArby34nqc1YjsLSoWdeJ/Lz/Je6owY5TjZi6cpCXS3E7xwBieehe2nKn1C2/AE4PQezoexH5nb/AGavegxHy3sPME/0gf5W1EEEEpJIhgRIi4Akzl3FDk1G7BKjHzZh+06iZyTiit/ExRvYcqr9bm3nrJ00w5tjW1HgJDZpLxO8htFE79imh4QzAUq9idHHL67iZ6LR7EEdNfprCzoxfjeu3I0WDM7wznIrU9fmWwYfrL4NObU478amp0620r6mF5iSRvJwMBkyKtUr5eFvYaGP4bCXFr2loFHWH7odJcqppVVcM2wMNMFcG5liaUHJH1V0z+Lw42tGFysNqw26TQvRXe0YqRdTddM4KgF2AFpPbaMU9IKtTSTUw2zyFmNcIhYnYGOvVmQ4szK/8NTv83lDGe1O9fHNrM4yrzuzHqT9I0BCtFKJ1uDvb0RMXTOsbJi03gSSm/pO0+yRr4Z/9/8A8icXAnZfZCx//M4/13HqNYHXQom8F4JSRCHCEOAEw0nFuLapD4gf6l/Fv3naTOLcdm2Iq6fMw+wtI008bBYmRTJeKkUiELU+yYamDmtADGiL3hOuVrgA6EG/6frOkUal5y7h57V087fWdJTYETn8nt2+H0skeLvK6nX6SbTeZytTojgMQDHllHDdol46VjbxCozxllkhxGKptAjZe0iYmrE1awlTjseqAsYudP1Ok5vmQpoT16DxmExFUuxY7kx/MMY1V+Y7dBIxnTjPxji8m7q/4IRxU0hMuklIvwjylVEiCwilhNvDWMkzpceH6TtvsrwxTBhiPnYkeInHMjwgrVkpseUO4W/a5no/L8MtKmiJ8qqFHpCFUm8F4IJRDEOJBiXrKu5A8yBGB1XAFzoBOF8W4sVMS7DYGwv6zb8W8WqvwIwO4O2s5ZiMSXZiepvM9NMfSrrb/wB95HeSaw3kdhCFr2bMNYdoI0JeCfldDfZgfvOo4Y3UeU5RRGs6lletND/pH4mHljr8F+j1ej1ETQrkGxku0j1qMxdKxw9QESZTYTPU6rJJiY8dY5RIs2cRDsLStbF+MS+MHeMJbtK7HYgRqtjidpENJnOu0XS4jMzOdNpnuIHt8N5q8QwRCewmDzSsXYk95pifbPyXmVdFot4m0ew9OdDinsVQSWiiw8pE3PrJhHyjz/Emqz+q9hqTCWE41ihKTUnCYgowI3BuDO48DcTriaYRyOdABruegnBRLnI81fD1EqIdVKm3RgCDY/SOJr0iDDvKvIc4TE0lqIRqPiW/xK3UEdNpZ3lBl874sWkAADc+F7TE57xC7Jzofma1yNesEEVOMi7Mzlm10vIVjeFBJqoRWSRmSCCJND3J/u0L3R7fiCCModo0zedK4dPNRTwFoIJj5HV4fS3CRBSCCY10EGheMvh4IIQEHDxJwkEEQKXCgQmFthBBKCizuobcomOxS3MOCa+Nh5/SP7qTqNK1vKCCbOfKJyfF6yW67GHBJpz9V9VDcwBDBBKZ0BTMdVSIIIw1HB+dvhqoYH4TYOutmUn8idgXPqZANz9GgglG/9k="));
            contacts.add(new Contact("Mi", "naima", "https://headicon.trovo.live/user/r35qkbqaaaaabp7ppdkzgasmcy.jpeg?t=0"));
            contacts.add(new Contact("Kim", "Kim", "data:image/jpeg;base64,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"));
            contacts.add(new Contact("Bensalem", "ZakariaJunior", "https://pbs.twimg.com/profile_images/492123209504784388/U0zn1OSb_400x400.jpeg"));
            contacts.add(new Contact("Bensalem", "Zakaria", "https://pbs.twimg.com/profile_images/687021065378332673/YbrIkKDd.jpg"));
            contacts.add(new Contact("Cena", "John", "data:image/jpeg;base64,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"));
            contacts.add(new Contact("Kristofer", "Simon", "https://scontent.flil1-1.fna.fbcdn.net/v/t1.18169-9/19149329_1411047585641069_117692613278510256_n.jpg?_nc_cat=105&ccb=1-5&_nc_sid=174925&_nc_ohc=DtfkrCiCwp4AX_l8VR3&_nc_ht=scontent.flil1-1.fna&oh=4f6e4ba7eec4884c6ca6341c350a276c&oe=61C217EE"));
            contacts.add(new Contact("Micalef", "Antoine", "https://scontent.flil1-1.fna.fbcdn.net/v/t1.6435-9/s600x600/107563123_1235412783464058_1100210813561061199_n.jpg?_nc_cat=101&ccb=1-5&_nc_sid=09cbfe&_nc_ohc=2inuiUVB57EAX-mmk5O&tn=Mw6O6OqUgwiO6tdH&_nc_ht=scontent.flil1-1.fna&oh=4e7d520dc38046c80065dcdc32d5344f&oe=61C0C176"));
            contacts.add(new Contact("Ennourie", "Hind","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS0hR85YPGBZKAH-Y9olWPF-s2pj4ey2r1S8w&usqp=CAU"));
            contacts.add(new Contact("Adissa", "Maria","https://scontent.flil1-1.fna.fbcdn.net/v/t31.18172-8/1401828_403047219846357_2605782048988958263_o.jpg?_nc_cat=111&ccb=1-5&_nc_sid=e3f864&_nc_ohc=fEJ0EdMqTcUAX_ID6d6&_nc_ht=scontent.flil1-1.fna&oh=4e5062aed37b36c73e32762b82900381&oe=61C25346"));
        }while(cpt <= 5);


        // Création d'un adaptater avec initialisation du constructeur avec notre list de contacts
        ContactsAdapter adapter = new ContactsAdapter(contacts);
        //On notifie au recyclerview notre adaptateur
        rvContacts.setAdapter(adapter);
        // On déclare quelle type de layoutManager on désire
        rvContacts.setLayoutManager(new LinearLayoutManager(this));
    }
}