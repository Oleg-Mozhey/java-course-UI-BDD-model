package Utils;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

@Name(value = "https://katalon-demo-cura.herokuapp.com/")
public class AppointmentPage extends WebPage{

    @Name("make appointment button")
    public static SelenideElement makeAppointmentButton = $("#btn-make-appointment");

    @Name("login input")
    public static SelenideElement loginInput = $("#txt-username");

    @Name("password input")
    public static SelenideElement passwordInput = $("#txt-password");

    @Name("submit button")
    public static SelenideElement submitButton = $("#btn-login");

    @Name("error message label")
    public static SelenideElement errorMessageLabel = $("#login > div > div > div.col-sm-12.text-center > p.lead.text-danger");

    @Name("select facility dropdown")
    public static SelenideElement selectFacilityDropdown = $("#combo_facility");

    @Name("Seoul CURA Healthcare Center item")
    public static SelenideElement seulCenter = $("#combo_facility > option:nth-child(3)");

    @Name("Medicaid radiobutton")
    public static SelenideElement medicaidRadiobutton = $("#radio_program_medicaid");

    @Name("Visit date datepicker")
    public static SelenideElement visitDateDatepicker = $("#txt_visit_date");

    @Name("Book appointment button")
    public static SelenideElement bookAppointmentButton = $("#btn-book-appointment");

    @Name("Appointment confirmation label")
    public static SelenideElement appointmentConfirmationLabel = $("#summary > div > div > div.col-xs-12.text-center");

    @Name("Menu toggle")
    public static SelenideElement menuToggle = $("#menu-toggle");

    @Name("Login button")
    public static SelenideElement loginButton = $("#sidebar-wrapper > ul > li:nth-child(4) > a");

    @Name("Profile button")
    public static SelenideElement profileButton = $("#sidebar-wrapper > ul > li:nth-child(5) > a");

    @Name("Profile information label")
    public static SelenideElement profileInformationLabel = $("#profile > div > div > div");

    @Name("History button")
    public static SelenideElement historyButton = $("#sidebar-wrapper > ul > li:nth-child(4) > a");

    @Name("Appointment table")
    public static SelenideElement appointmentTable = $("#history > div > div:nth-child(2) > div");
}


