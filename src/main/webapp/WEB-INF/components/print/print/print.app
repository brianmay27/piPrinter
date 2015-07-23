<aura:application model="java://print.controllers.MainAppController">
    <print:header isAdmin="{#m.isAdmin}"/>
    <aura:if isTrue="{!m.isAdmin}">
        Hello admin!
    </aura:if>
    <print:fileUploader/>
    <print:admin/>
</aura:application>
