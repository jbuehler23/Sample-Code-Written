<%@ Page Title="" Language="C#" MasterPageFile="~/Views/Shared/Site.Master" Inherits="System.Web.Mvc.ViewPage<IEnumerable<BusinessApp.Models.instructor>>" %>

<asp:Content ID="Content1" ContentPlaceHolderID="TitleContent" runat="server">
	ViewPage1
</asp:Content>

<asp:Content ID="Content2" ContentPlaceHolderID="MainContent" runat="server">

    <h2>ViewPage1</h2>

    <table>
        <tr>
            <th></th>
            <th>
                Instructor_id
            </th>
            <th>
                First_Name
            </th>
            <th>
                Last_Name
            </th>
            <th>
                Full_Name
            </th>
            <th>
                Email
            </th>
            <th>
                Phone_Number
            </th>
            <th>
                Department
            </th>
            <th>
                Pref_Location
            </th>
        </tr>

    <% foreach (var item in Model) { %>
    
        <tr>
            <td>
                <%: Html.ActionLink("Edit", "Edit", new { id=item.Instructor_id }) %> |
                <%: Html.ActionLink("Details", "Details", new { id=item.Instructor_id })%> |
                <%: Html.ActionLink("Delete", "Delete", new { id=item.Instructor_id })%>
            </td>
            <td>
                <%: item.Instructor_id %>
            </td>
            <td>
                <%: item.First_Name %>
            </td>
            <td>
                <%: item.Last_Name %>
            </td>
            <td>
                <%: item.Full_Name %>
            </td>
            <td>
                <%: item.Email %>
            </td>
            <td>
                <%: item.Phone_Number %>
            </td>
            <td>
                <%: item.Department %>
            </td>
            <td>
                <%: item.Pref_Location %>
            </td>
        </tr>
    
    <% } %>

    </table>

    <p>
        <%: Html.ActionLink("Create New", "Create") %>
    </p>

</asp:Content>

