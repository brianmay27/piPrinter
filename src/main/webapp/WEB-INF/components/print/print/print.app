<aura:application model="java://ui.aura.components.print.controllers.MainAppController">
    <print:header isAdmin="{#m.isAdmin}"/>
    <aura:if isTrue="{!m.isAdmin}">
        Hello admin!
    </aura:if>
    <print:fileUploader/>
    <print:fileList/>
</aura:application>
