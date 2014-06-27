<%@ Page Title="" Language="C#" MasterPageFile="~/Views/Shared/Site.Master" Inherits="System.Web.Mvc.ViewPage<IEnumerable<BusinessApp.Models.students_table>>" %>

<asp:Content ID="Content1" ContentPlaceHolderID="TitleContent" runat="server">
	Index
</asp:Content>

<asp:Content ID="Content2" ContentPlaceHolderID="MainContent" runat="server">

    <h2>Index</h2>

    <table>
        <tr>
            <th></th>
            <th>
                IONA_Student_id
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
                Date_of_Birth
            </th>
            <th>
                Age
            </th>
            <th>
                Email
            </th>
            <th>
                Phone_Number
            </th>
            <th>
                Street_Address
            </th>
            <th>
                City
            </th>
            <th>
                Zip_Code
            </th>
            <th>
                Total_Credits_Complete
            </th>
            <th>
                Prefered_Location
            </th>
            <th>
                MBA_Speed
            </th>
            <th>
                Student_Type
            </th>
            <th>
                Days_Available
            </th>
            <th>
                Athlete
            </th>
            <th>
                Loans
            </th>
            <th>
                Status
            </th>
        </tr>

    <% foreach (var item in Model) { %>
    
        <tr>
            <td>
                <%: Html.ActionLink("Edit", "Edit", new { id=item.IONA_Student_id }) %> |
                <%: Html.ActionLink("Details", "Details", new { id=item.IONA_Student_id })%> |
                <%: Html.ActionLink("Delete", "Delete", new { id=item.IONA_Student_id })%>
            </td>
            <td>
                <%: item.IONA_Student_id %>
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
                <%: item.Date_of_Birth %>
            </td>
            <td>
                <%: item.Age %>
            </td>
            <td>
                <%: item.Email %>
            </td>
            <td>
                <%: item.Phone_Number %>
            </td>
            <td>
                <%: item.Street_Address %>
            </td>
            <td>
                <%: item.City %>
            </td>
            <td>
                <%: item.Zip_Code %>
            </td>
            <td>
                <%: item.Total_Credits_Complete %>
            </td>
            <td>
                <%: item.Prefered_Location %>
            </td>
            <td>
                <%: item.MBA_Speed %>
            </td>
            <td>
                <%: item.Student_Type %>
            </td>
            <td>
                <%: item.Days_Available %>
            </td>
            <td>
                <%: item.Athlete %>
            </td>
            <td>
                <%: item.Loans %>
            </td>
            <td>
                <%: item.Status %>
            </td>
        </tr>
    
    <% } %>

    </table>

    <p>
        <%: Html.ActionLink("Create New", "Create") %>
    </p>

</asp:Content>

