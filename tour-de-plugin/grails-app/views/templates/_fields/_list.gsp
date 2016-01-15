<g:each in="${domainClass.persistentProperties}" var="p">
    <div class="row">
        <label class="col-xs-3"><g:message code="${domainClass.propertyName}.${p.name}.label" default="${p.naturalName}"/></label>

        <div class="col-xs-9">${body(p)}</div>
    </div>
</g:each>