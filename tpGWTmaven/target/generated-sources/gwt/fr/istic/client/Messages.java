package fr.istic.client;

/**
 * Interface to represent the messages contained in resource bundle:
 * 	/ws/14011107/tmp-git/TPJerseyGWT/tpGWTmaven/src/main/resources/fr/istic/client/Messages.properties'.
 */
public interface Messages extends com.google.gwt.i18n.client.Messages {
  
  /**
   * Translated "Adresse :".
   * 
   * @return translated "Adresse :"
   */
  @DefaultMessage("Adresse :")
  @Key("label_mail")
  String label_mail();

  /**
   * Translated "Nom :".
   * 
   * @return translated "Nom :"
   */
  @DefaultMessage("Nom :")
  @Key("label_nom")
  String label_nom();

  /**
   * Translated "Prenom :".
   * 
   * @return translated "Prenom :"
   */
  @DefaultMessage("Prenom :")
  @Key("label_prenom")
  String label_prenom();

  /**
   * Translated "Creation nouvelle personne".
   * 
   * @return translated "Creation nouvelle personne"
   */
  @DefaultMessage("Creation nouvelle personne")
  @Key("label_titre_creer")
  String label_titre_creer();

  /**
   * Translated "".
   * 
   * @return translated ""
   */
  @DefaultMessage("")
  @Key("nameField")
  String nameField();

  /**
   * Translated "Send".
   * 
   * @return translated "Send"
   */
  @DefaultMessage("Send")
  @Key("sendButton")
  String sendButton();
}
