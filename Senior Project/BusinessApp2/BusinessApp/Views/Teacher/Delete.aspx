<%@ Page Title="" Language="C#" MasterPageFile="~/Views/Shared/Site.Master" Inherits="System.Web.Mvc.ViewPage<BusinessApp.Models.instructor>" %>

<asp:Content ID="Content1" ContentPlaceHolderID="TitleContent" runat="server">
	Delete
</asp:Content>

<asp:Content ID="Content2" ContentPlaceHolderID="MainContent" runat="server">

    <h2>Delete</h2>

    <h3>Are you sure you want to delete this?</h3>
    <fieldset>
        <legend>Fields</legend>
        
        <div class="display-label">Instructor_id</div>
        <div class="display-field"><%: Model.Instructor_id %></div>
        
        <div class="display-label">First_Name</div>
        <div class="display-field"><%: Model.First_Name %></div>
        
        <div class="display-label">Last_Name</div>
        <div class="display-field"><%: Model.Last_Name %></div>
        
        <div class="display-label">Full_Name</div>
        <div class="display-field"><%: Model.Full_Name %></div>
        
        <div class="display-label">Email</div>
        <div class="display-field"><%: Model.Email %></div>
        
        <div class="display-label">Phone_Number</div>
        <div class="display-field"><%: Model.Phone_Number %></div>
        
        <div class="display-label">Department</div>
        <div class="display-field"><%: Model.Department %></div>
        
        <div class="display-label">Pref_Location</div>
        <div class="display-field"><%: Model.Pref_Location %></div>
        
    </fieldset>
    <% using (Html.BeginForm()) { %>
        <p>
		    <input type="submit" value="Delete" /> |
		    <%: Html.ActionLink("Back to List", "Index") %>
        </p>
    <% } %>

</asp:Content>

