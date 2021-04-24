package ist311group5.ist311group5;

public interface Controller {
    /**
     * Changes control to another controller class
     * @param controller Name of controller or action 
     */
    public abstract void changeControl(String controller);
    
    /**
     * Retrieves the general settings.
     * @return The theme and font size.
     */
    public String[] getGeneralSetting();
}