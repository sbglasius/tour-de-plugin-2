<%-- Note, this only works for images of type png, so it should probably be overriden for specific fields --%>
<img src="data:image/png;base64,${bean."$property".encodeBase64().toString()}"/>
