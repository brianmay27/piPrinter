<aura:application model="java://print.controllers.MainAppController">
    <print:header isAdmin="{#m.isAdmin}"/>
    <print:fileUploader/>
    <print:admin/>
    <ui:dialogManager/>
</aura:application>
