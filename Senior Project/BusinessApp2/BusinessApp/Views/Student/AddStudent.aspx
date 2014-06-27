<%@ Page Title="" Language="C#" MasterPageFile="~/Views/Shared/Site.Master" Inherits="System.Web.Mvc.ViewPage<dynamic>" %>


<asp:Content ID="Content1" ContentPlaceHolderID="TitleContent" runat="server">
	Student
</asp:Content>

<asp:Content ID="Content2" ContentPlaceHolderID="MainContent" runat="server">

    <h2 align="center" style="font-family: 'Bookman Old Style'">
        <span style="font-weight: normal"><em style="color: #FFFFFF">New Student Page</em></span></h2>

        <%=Html.ValidationSummary("There are errors in the input, please fix and resubmit.") %>
        
         <% using (Html.BeginForm("AddStudent", "Student")) { %>
                <table align="center">
                    <tr>
                        <td>What is the student's first name?</td>
                        <td style="width: 204px">
                            <%=Html.TextBox("firstName") %>
                            <%=Html.ValidationMessage("firstName", "****") %>
                        </td>
                    </tr>

                    <tr>
                        <td>What is the student's last name?</td>
                        <td style="width: 204px">
                            <%=Html.TextBox("lastName") %>
                            <%=Html.ValidationMessage("lastName", "****") %>
                        </td>
                    </tr>

                    <tr>
                        <td>Enter Student ID</td>
                        <td style="width: 204px">
                                <%=Html.TextBox("ionaID") %>
                                <%=Html.ValidationMessage("ionaID", "****") %>
                        </td>
                    
                    </tr>

                    <tr>
                        <td>What is the student's address?</td>
                        <td>
                            <%=Html.TextBox("address") %>
                            <%=Html.ValidationMessage("address", "****") %>
                        </td>
                    </tr>

                    <tr>
                        <td>What is the student's DOB</td>
                        <td>
                            <%=Html.TextBox("DOB") %>
                            <%=Html.ValidationMessage("DOB", "****") %>
                        </td>
                    </tr>

                    <tr>
                        <td>What is the student's email</td>
                        <td>
                            <%=Html.TextBox("email") %>
                            <%=Html.ValidationMessage("email", "****") %>
                        </td>
                    </tr>

                    <tr>
                        <td>What is the student's phone number</td>
                        <td>
                            <%=Html.TextBox("phoneNum") %>
                            <%=Html.ValidationMessage("phoneNum", "****") %>
                        </td>
                    </tr>

                    <tr>
                        <td>What is the student's city</td>
                        <td>
                            <%=Html.TextBox("city") %>
                            <%=Html.ValidationMessage("city", "****") %>
                        </td>
                    </tr>

                    <tr>
                        <td>What is the student's ZIP</td>
                        <td>
                            <%=Html.TextBox("zip") %>
                            <%=Html.ValidationMessage("zip", "****") %>
                        </td>
                    </tr>

                    <tr>
                        <td>What is the student's total credits completed</td>
                        <td>
                            <%=Html.TextBox("totalCredits") %>
                            <%=Html.ValidationMessage("totalCredits", "****") %>
                        </td>
                    </tr>

                    <tr>
                        <td>What is the preferred location to attend class?</td>
                        <td style="width: 204px">
                            <%=Html.DropDownList("preferredLocation") %>
                            <%=Html.ValidationMessage("class", "****") %>
                        </td>
                    </tr>
                    <tr>
                        <td>US or International student?</td>
                        <td style="width: 204px">  
                            <select id="studentType" name="studentType">
                                <option>US</option>
                                <option>International</option>
                            </select>
                        </td>
                    
                    </tr>
                
                   
                    <tr>
                        <td>Select all days student is free during the week</td>
                        <td>
                         
                            Monday <%= Html.CheckBox("n[0]") %><%= Html.Hidden("n[0]",false) %> <br />
                            Tuesday <%= Html.CheckBox("n[1]") %><%= Html.Hidden("n[1]",false) %><br />
                            Wednesday <%= Html.CheckBox("n[2]") %><%= Html.Hidden("n[2]",false) %><br />
                            Thursday <%= Html.CheckBox("n[3]") %><%= Html.Hidden("n[3]",false) %><br />
                            Friday <%= Html.CheckBox("n[4]") %><%= Html.Hidden("n[4]",false) %><br />

                        </td>
                    </tr>
                    <tr>
                        <td>Athlete?</td>
                        <td>
                        <%= Html.CheckBox("athlete") %>
                        </td>
                    </tr>
                    
                    <tr>
                        <td>Accepting Student Loans?</td>
                        <td><%= Html.CheckBox("acceptingLoans") %>
                        </td>
                    </tr>

                    <tr>
                        <td>Has Waived Credits?</td>
                        <td>
                        <%= Html.CheckBox("waivedCredits") %>
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
