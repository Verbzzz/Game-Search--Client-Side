package com.hit.client;

import java.io.Serializable;
import java.util.UUID;

public class Game implements Serializable {
    final String uuid = UUID.randomUUID().toString();
    private String GameName;
    private String Genre;
    private String GameCompanyDevelop;
    private String GameStoreName;
    private String AddressStore;

    public Game(String gameName, String genre, String gameCompanyDevelop, String gameStoreName, String addressStore) {
        this.GameName = gameName;
        this.Genre = genre;
        this.GameCompanyDevelop = gameCompanyDevelop;
        this.GameStoreName = gameStoreName;
        this.AddressStore = addressStore;

    }


    public String getGameName() {
        return GameName;
    }

    public String getGenre() {
        return Genre;
    }

    public String getGameCompanyDevelop() {
        return GameCompanyDevelop;
    }

    public String getGameStoreName() {
        return GameStoreName;
    }

    public String getAddressStore() {
        return AddressStore;
    }

    public String getUuid() {
        return uuid;
    }

    public void setGameName(String Name) {
        this.GameName = Name;
    }

    public void setGenre(String Genre) {
        this.Genre = Genre;
    }

    public void setGameCompanyDevelop(String GameCompanyDevelop) {
        this.GameCompanyDevelop = GameCompanyDevelop;
    }

    public void setGameStoreName(String GameStoreName) {
        this.GameStoreName = GameStoreName;
    }

    public void setAddressStore(String AddressStore) {
        this.AddressStore = AddressStore;
    }

    @Override
    public String toString() {
        return "Game{" +
                "uuid='" + uuid + '\'' +
                ", GameName='" + GameName + '\'' +
                ", Genre='" + Genre + '\'' +
                ", GameCompanyDevelop='" + GameCompanyDevelop + '\'' +
                ", GameStoreName='" + GameStoreName + '\'' +
                ", AddressStore='" + AddressStore + '\'' +
                '}';
    }

}


