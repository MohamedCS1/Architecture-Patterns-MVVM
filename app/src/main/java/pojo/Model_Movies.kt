package pojo

class Model_Movies {
    var Title:String? = null
    var Date_Publication:String? = null
    var Print_Lenght:Int? = null
    var Language:String? = null

    constructor(Title:String?,Date_Publication:String?,Print_Lenght:Int?,Language:String?)
    {
        this.Title = Title
        this.Date_Publication = Date_Publication
        this.Print_Lenght = Print_Lenght
        this.Language = Language
    }
}