package com.cabbooking.cabbooking.modal;

import jakarta.persistence.Embeddable;


public class PaymentDetails {

    private PaymentStatus paymentStatus;
    private String paymentId;
    private String razorpayPaymentLinkId;
    private String razorpayPaymentLinkReferenceId;
    private String razorpayPaymentLinkStatus;
    private String razorpayPaymentId;


}
