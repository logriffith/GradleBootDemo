import { FavoriteColor } from "./favorite-color";

export class User {

    public userId: number;
    public firstName: string;
    public lastName: string;
    public color: FavoriteColor;

    constructor(userId: number, firstName: string, lastName: string, color: FavoriteColor){
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.color = color;
    }
}
