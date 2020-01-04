package edu.upc.dsa.models;

public class UserObject {   //relaciona los usuarios con los objetos

    int idUser;
    int idObject;

    public UserObject(int iduser, int idobject) {

        this.idUser = iduser;
        this.idObject = idobject;
    }


    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public int getIdObject() {
        return idObject;
    }

    public void setIdObject(int idObject) {
        this.idObject = idObject;
    }
}
