package tools;
public class ToolBox
{
    //wartosci typu boolean wyrazajace czy dany przycisk z paska narzedzi jest aktualnie wybrany
    private boolean ifLineSelected;
    private boolean ifBrushSelected;
    private boolean ifFillSelected;
    private boolean ifPencilSelected;
    private boolean ifEraserSelected;
    private boolean ifCircleSelected;
    private boolean ifRectangleSelected;

    /*kontruktor domyslny ustawiajacy wartosci typu boolean na false z wyjatkiem tej odpowiedzialnej za wybor olowka
    pozwala nam to rysowac olowkiem od razu po uruchomieniu programu*/
    public ToolBox()
    {
        this.ifEraserSelected = false;
        this.ifPencilSelected = true;
        this.ifFillSelected = false;
        this.ifBrushSelected = false;
        this.ifLineSelected = false;
        this.ifCircleSelected = false;
        this.ifRectangleSelected = false;
    }

    //metoda wirtualna nadpisywana w klasach dziedziczacych
    public void toolSelected()
    {

    }

    //metody ustawiajace wartosci typu boolean
    public void setIfLineSelected(boolean value)
    {
        this.ifLineSelected = value;
    }
    public void setIfBrushSelected(boolean value)
    {
        this.ifBrushSelected = value;
    }
    public void setIfFillSelected(boolean value)
    {
        this.ifFillSelected = value;
    }
    public void setIfPencilSelected(boolean value)
    {
        this.ifPencilSelected = value;
    }
    public void setIfEraserSelected(boolean value)
    {
        this.ifEraserSelected = value;
    }
    public void setIfCircleSelected(boolean value)
    {
        this.ifCircleSelected = value;
    }
    public void setIfRectangleSelected(boolean value)
    {
        this.ifRectangleSelected = value;
    }


    //metody zwracajace wartosci pol typu boolean
    public boolean getIfLineSelected()
    {
        return ifLineSelected;
    }

    public boolean getIfBrushSelected() {
        return ifBrushSelected;
    }

    public boolean getIfEraserSelected() {
        return ifEraserSelected;
    }

    public boolean getIfFillSelected() {
        return ifFillSelected;
    }

    public boolean getIfPencilSelected() {
        return ifPencilSelected;
    }

    public boolean getIfCircleSelected()
    {
        return ifCircleSelected;
    }

    public boolean getIfRectangleSelected()
    {
        return ifRectangleSelected;
    }
}
