<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <title>Connexion</title>
        <link type="text/css" rel="stylesheet" href="<c:url value="/inc/form.css"/>" />
    </head>
    <body>
        <form method="post" action="authentification">
            <fieldset>
                <legend>Connexion</legend>
                <p>Vous pouvez vous connecter via ce formulaire.</p>
                
                                
                <label for="nom">Nom d'utilisateur</label>
                <input type="text" id="nom" name="nom" value="<c:out value="${utilisateurconnect�.nom}"/>" size="20" maxlength="20" />
                <span class="erreur">${formconnect�.erreurs['nom']}</span>
                <br />         

                <label for="motdepasse">Mot de passe <span class="requis">*</span></label>
                <input type="password" id="motdepasse" name="motdepasse" value="" size="20" maxlength="20" />
                <span class="erreur">${formconnect�.erreurs['motdepasse']}</span>
                <br />

                <input type="submit" value="se connecter" class="sansLabel" />
                <br />
                
                <p class="${empty formconnect�.erreurs ? 'succes' : 'erreur'}">${formconnect�.resultat}</p>
                <%-- V�rification de la pr�sence d'un objet utilisateur en session --%>
                <c:if test="${!empty sessionScope.sessionUtilisateur}">
                    <%-- Si l'utilisateur existe en session, alors on affiche son adresse email. --%>
                    <p class="succes">Vous �tes connect�(e) avec le nom : ${sessionScope.sessionUtilisateur.nom}</p>
                </c:if>
            </fieldset>
        </form>
    </body>
</html>