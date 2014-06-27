<%@ Page Title="" Language="C#" MasterPageFile="~/Views/Shared/Site.Master" Inherits="System.Web.Mvc.ViewPage<BusinessApp.Models.instructor>" %>

<asp:Content ID="Content1" ContentPlaceHolderID="TitleContent" runat="server">
	Create
</asp:Content>

<asp:Content ID="Content2" ContentPlaceHolderID="MainContent" runat="server">

    <h2>Create</h2>

    <% using (Html.BeginForm()) {%>
        <%: Html.ValidationSummary(true) %>

        <fieldset>
            <legend>Fields</legend>
            
            <div class="editor-label">
                <%: Html.LabelFor(model => model.Instructor_id) %>
            </div>
            <div class="editor-field">
                <%: Html.TextBoxFor(model => model.Instructor_id) %>
                <%: Html.ValidationMessageFor(model => model.Instructor_id) %>
            </div>
            
            <div class="editor-label">
                <%: Html.LabelFor(model => model.First_Name) %>
            </div>
            <div class="editor-field">
                <%: Html.TextBoxFor(model => model.First_Name) %>
                <%: Html.ValidationMessageFor(model => model.First_Name) %>
            </div>
            
            <div class="editor-label">
                <%: Html.LabelFor(model => model.Last_Name) %>
            </div>
            <div class="editor-field">
                <%: Html.TextBoxFor(model => model.Last_Name) %>
                <%: Html.ValidationMessageFor(model => model.Last_Name) %>
            </div>
            
            <div class="editor-label">
                <%: Html.LabelFor(model => model.Full_Name) %>
            </div>
            <div class="editor-field">
                <%: Html.TextBoxFor(model => model.Full_Name) %>
                <%: Html.ValidationMessageFor(model => model.Full_Name) %>
            </div>
            
            <div class="editor-label">
                <%: Html.LabelFor(model => model.Email) %>
            </div>
            <div class="editor-field">
                <%: Html.TextBoxFor(model => model.Email) %>
                <%: Html.ValidationMessageFor(model => model.Email) %>
            </div>
            
            <div class="editor-label">
                <%: Html.LabelFor(model => model.Phone_Number) %>
            </div>
            <div class="editor-field">
                <%: Html.TextBoxFor(model => model.Phone_Number) %>
                <%: Html.ValidationMessageFor(model => model.Phone_Number) %>
            </div>
            
            <div class="editor-label">
                <%: Html.LabelFor(model => model.Department) %>
            </div>
            <div class="editor-field">
                <%: Html.DropDownList("Department", string.Empty) %>
                <%: Html.ValidationMessageFor(model => model.Department) %>
            </div>
            
            <div class="editor-label">
                <%: Html.LabelFor(model => model.Pref_Location) %>
            </div>
            <div class="editor-field">
                <%: Html.DropDownList("Pref_Location", string.Empty) %>
                <%: Html.ValidationMessageFor(model => model.Pref_Location) %>
            </div>
            
            <p>
                <input type="submit" value="Create" />
            </p>
        </fieldset>

    <% } %>

    <div>
        <%: Html.ActionLink("Back to List", "Index") %>
    </div>

</asp:Content>

