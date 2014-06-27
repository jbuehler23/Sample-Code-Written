<%@ Page Title="" Language="C#" MasterPageFile="~/Views/Shared/Site.Master" Inherits="System.Web.Mvc.ViewPage<dynamic>" %>

<asp:Content ID="Content1" ContentPlaceHolderID="TitleContent" runat="server">
	LookupStudent
</asp:Content>

<asp:Content ID="Content2" ContentPlaceHolderID="MainContent" runat="server">

    <h2 align="center" style="font-family: 'Bookman Old Style'">
        <span style="font-weight: normal"><em style="color: #FFFFFF">Student Search Page</em></span></h2>

        <%=Html.ValidationSummary("There are errors in the input, please fix and resubmit.") %>
        
         <% using (Html.BeginForm("LookupStudentID", "Student")) { %>
            
            <table align="center">
                   <tr>
                       <td>Search by student ID</td>
                       <td style="width: 204px">
                            <%=Html.TextBox("studID") %>
                            <%=Html.ValidationMessage("studID", "**") %>
                       </td>
                   </tr>

                   <tr>
                    <td></td>
                    <td> 
                    
                    <input type="submit" value="Submit" />
                    
                    </td>
                    </tr>


                   </table>
                <% } %>

            <%=Html.ValidationSummary("There are errors in the input, please fix and resubmit.") %>

            <br />
            OR
            <br />
            <br />
        
            <% using (Html.BeginForm("LookupStudentName", "Student")) { %>
            
            <table align="center">
                   <tr>
                       <td>Search by student last name</td>
                       <td style="width: 204px">
                            <%=Html.TextBox("studName") %>
                            <%=Html.ValidationMessage("studName", "**") %>
                       </td>
                   </tr>

                   <tr>
                    <td></td>
                    <td> 
                    
                    <input type="submit" value="Submit" />
                    
                    </td>
                    </tr>
                    </table>

                     <% } %>

</asp:Content>
