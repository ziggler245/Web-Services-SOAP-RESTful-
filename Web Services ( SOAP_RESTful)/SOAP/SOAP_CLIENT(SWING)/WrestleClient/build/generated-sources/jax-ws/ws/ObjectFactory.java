
package ws;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the ws package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _GetAllCountries_QNAME = new QName("http://ws/", "getAllCountries");
    private final static QName _GetAllPpvResponse_QNAME = new QName("http://ws/", "getAllPpvResponse");
    private final static QName _GetAllFights_QNAME = new QName("http://ws/", "getAllFights");
    private final static QName _GetAllFightsResponse_QNAME = new QName("http://ws/", "getAllFightsResponse");
    private final static QName _GetAllCountriesResponse_QNAME = new QName("http://ws/", "getAllCountriesResponse");
    private final static QName _Insert_QNAME = new QName("http://ws/", "insert");
    private final static QName _CheckResponse_QNAME = new QName("http://ws/", "checkResponse");
    private final static QName _GetAllPpv_QNAME = new QName("http://ws/", "getAllPpv");
    private final static QName _Check_QNAME = new QName("http://ws/", "check");
    private final static QName _GetAllSeatsResponse_QNAME = new QName("http://ws/", "getAllSeatsResponse");
    private final static QName _InsertResponse_QNAME = new QName("http://ws/", "insertResponse");
    private final static QName _GetAllFightsPpv_QNAME = new QName("http://ws/", "getAllFightsPpv");
    private final static QName _Exceptions_QNAME = new QName("http://ws/", "Exceptions");
    private final static QName _GetAllSeats_QNAME = new QName("http://ws/", "getAllSeats");
    private final static QName _GetAllFightsPpvResponse_QNAME = new QName("http://ws/", "getAllFightsPpvResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ws
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetAllCountries }
     * 
     */
    public GetAllCountries createGetAllCountries() {
        return new GetAllCountries();
    }

    /**
     * Create an instance of {@link GetAllPpvResponse }
     * 
     */
    public GetAllPpvResponse createGetAllPpvResponse() {
        return new GetAllPpvResponse();
    }

    /**
     * Create an instance of {@link GetAllFights }
     * 
     */
    public GetAllFights createGetAllFights() {
        return new GetAllFights();
    }

    /**
     * Create an instance of {@link GetAllFightsResponse }
     * 
     */
    public GetAllFightsResponse createGetAllFightsResponse() {
        return new GetAllFightsResponse();
    }

    /**
     * Create an instance of {@link GetAllCountriesResponse }
     * 
     */
    public GetAllCountriesResponse createGetAllCountriesResponse() {
        return new GetAllCountriesResponse();
    }

    /**
     * Create an instance of {@link Insert }
     * 
     */
    public Insert createInsert() {
        return new Insert();
    }

    /**
     * Create an instance of {@link CheckResponse }
     * 
     */
    public CheckResponse createCheckResponse() {
        return new CheckResponse();
    }

    /**
     * Create an instance of {@link GetAllPpv }
     * 
     */
    public GetAllPpv createGetAllPpv() {
        return new GetAllPpv();
    }

    /**
     * Create an instance of {@link Check }
     * 
     */
    public Check createCheck() {
        return new Check();
    }

    /**
     * Create an instance of {@link GetAllSeatsResponse }
     * 
     */
    public GetAllSeatsResponse createGetAllSeatsResponse() {
        return new GetAllSeatsResponse();
    }

    /**
     * Create an instance of {@link InsertResponse }
     * 
     */
    public InsertResponse createInsertResponse() {
        return new InsertResponse();
    }

    /**
     * Create an instance of {@link GetAllFightsPpv }
     * 
     */
    public GetAllFightsPpv createGetAllFightsPpv() {
        return new GetAllFightsPpv();
    }

    /**
     * Create an instance of {@link Exceptions }
     * 
     */
    public Exceptions createExceptions() {
        return new Exceptions();
    }

    /**
     * Create an instance of {@link GetAllSeats }
     * 
     */
    public GetAllSeats createGetAllSeats() {
        return new GetAllSeats();
    }

    /**
     * Create an instance of {@link GetAllFightsPpvResponse }
     * 
     */
    public GetAllFightsPpvResponse createGetAllFightsPpvResponse() {
        return new GetAllFightsPpvResponse();
    }

    /**
     * Create an instance of {@link Fight }
     * 
     */
    public Fight createFight() {
        return new Fight();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllCountries }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws/", name = "getAllCountries")
    public JAXBElement<GetAllCountries> createGetAllCountries(GetAllCountries value) {
        return new JAXBElement<GetAllCountries>(_GetAllCountries_QNAME, GetAllCountries.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllPpvResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws/", name = "getAllPpvResponse")
    public JAXBElement<GetAllPpvResponse> createGetAllPpvResponse(GetAllPpvResponse value) {
        return new JAXBElement<GetAllPpvResponse>(_GetAllPpvResponse_QNAME, GetAllPpvResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllFights }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws/", name = "getAllFights")
    public JAXBElement<GetAllFights> createGetAllFights(GetAllFights value) {
        return new JAXBElement<GetAllFights>(_GetAllFights_QNAME, GetAllFights.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllFightsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws/", name = "getAllFightsResponse")
    public JAXBElement<GetAllFightsResponse> createGetAllFightsResponse(GetAllFightsResponse value) {
        return new JAXBElement<GetAllFightsResponse>(_GetAllFightsResponse_QNAME, GetAllFightsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllCountriesResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws/", name = "getAllCountriesResponse")
    public JAXBElement<GetAllCountriesResponse> createGetAllCountriesResponse(GetAllCountriesResponse value) {
        return new JAXBElement<GetAllCountriesResponse>(_GetAllCountriesResponse_QNAME, GetAllCountriesResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Insert }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws/", name = "insert")
    public JAXBElement<Insert> createInsert(Insert value) {
        return new JAXBElement<Insert>(_Insert_QNAME, Insert.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CheckResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws/", name = "checkResponse")
    public JAXBElement<CheckResponse> createCheckResponse(CheckResponse value) {
        return new JAXBElement<CheckResponse>(_CheckResponse_QNAME, CheckResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllPpv }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws/", name = "getAllPpv")
    public JAXBElement<GetAllPpv> createGetAllPpv(GetAllPpv value) {
        return new JAXBElement<GetAllPpv>(_GetAllPpv_QNAME, GetAllPpv.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Check }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws/", name = "check")
    public JAXBElement<Check> createCheck(Check value) {
        return new JAXBElement<Check>(_Check_QNAME, Check.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllSeatsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws/", name = "getAllSeatsResponse")
    public JAXBElement<GetAllSeatsResponse> createGetAllSeatsResponse(GetAllSeatsResponse value) {
        return new JAXBElement<GetAllSeatsResponse>(_GetAllSeatsResponse_QNAME, GetAllSeatsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InsertResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws/", name = "insertResponse")
    public JAXBElement<InsertResponse> createInsertResponse(InsertResponse value) {
        return new JAXBElement<InsertResponse>(_InsertResponse_QNAME, InsertResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllFightsPpv }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws/", name = "getAllFightsPpv")
    public JAXBElement<GetAllFightsPpv> createGetAllFightsPpv(GetAllFightsPpv value) {
        return new JAXBElement<GetAllFightsPpv>(_GetAllFightsPpv_QNAME, GetAllFightsPpv.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Exceptions }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws/", name = "Exceptions")
    public JAXBElement<Exceptions> createExceptions(Exceptions value) {
        return new JAXBElement<Exceptions>(_Exceptions_QNAME, Exceptions.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllSeats }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws/", name = "getAllSeats")
    public JAXBElement<GetAllSeats> createGetAllSeats(GetAllSeats value) {
        return new JAXBElement<GetAllSeats>(_GetAllSeats_QNAME, GetAllSeats.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllFightsPpvResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws/", name = "getAllFightsPpvResponse")
    public JAXBElement<GetAllFightsPpvResponse> createGetAllFightsPpvResponse(GetAllFightsPpvResponse value) {
        return new JAXBElement<GetAllFightsPpvResponse>(_GetAllFightsPpvResponse_QNAME, GetAllFightsPpvResponse.class, null, value);
    }

}
