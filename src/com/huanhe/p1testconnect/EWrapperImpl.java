package com.huanhe.p1testconnect;

import com.ib.client.*;

import java.util.Set;

public class EWrapperImpl implements EWrapper {

/*
 * EWrapperImpl用于TWS向API客户端应用程序传递消息，
 * 中间需要消息队列处理机制：EReaderSignal接口的实现类EJavaSignal，使用其中的issueSignal()方法和waitForSignal()方法
 * 创建EClientSocket对象，将EWrapperImpl类功能扩展成TWS与API之间消息交互的类，EClientSocket用于API客户端向TWS发送消息
 *  如此一来，消息的传递可共用一个消息队列处理。
 *
 */

    //socket declare
    private EReaderSignal readerSignal;
    private EClientSocket clientSocket;
    int currentOrderId = -1; // -1 表示连接状态（成功）
    //end socket declare


    // socket init
    public EWrapperImpl() {
        readerSignal = new EJavaSignal(); // Create signal object
        clientSocket = new EClientSocket(this, readerSignal); // Create socket object
    }
    //end socket init

    public EReaderSignal getSignal() {
        return readerSignal;
    }

    public EClientSocket getSocket() {
        return clientSocket;
    }

    public int getCurrentOrderId() {
        return currentOrderId;
    }

    @Override
    public void tickPrice(int i, int i1, double v, int i2) {

    }

    @Override
    public void tickSize(int i, int i1, int i2) {

    }

    @Override
    public void tickOptionComputation(int i, int i1, double v, double v1, double v2, double v3, double v4, double v5, double v6, double v7) {

    }

    @Override
    public void tickGeneric(int i, int i1, double v) {

    }

    @Override
    public void tickString(int i, int i1, String s) {

    }

    @Override
    public void tickEFP(int i, int i1, double v, String s, double v1, int i2, String s1, double v2, double v3) {

    }

    @Override
    public void orderStatus(int i, String s, double v, double v1, double v2, int i1, int i2, double v3, int i3, String s1) {

    }

    @Override
    public void openOrder(int i, Contract contract, Order order, OrderState orderState) {

    }

    @Override
    public void openOrderEnd() {

    }

    @Override
    public void updateAccountValue(String s, String s1, String s2, String s3) {

    }

    @Override
    public void updatePortfolio(Contract contract, double v, double v1, double v2, double v3, double v4, double v5, String s) {

    }

    @Override
    public void updateAccountTime(String s) {

    }

    @Override
    public void accountDownloadEnd(String s) {

    }

    @Override
    public void nextValidId(int orderId) {
        currentOrderId = orderId;
    }

    @Override
    public void contractDetails(int i, ContractDetails contractDetails) {

    }

    @Override
    public void bondContractDetails(int i, ContractDetails contractDetails) {

    }

    @Override
    public void contractDetailsEnd(int i) {

    }

    @Override
    public void execDetails(int i, Contract contract, Execution execution) {

    }

    @Override
    public void execDetailsEnd(int i) {

    }

    @Override
    public void updateMktDepth(int i, int i1, int i2, int i3, double v, int i4) {

    }

    @Override
    public void updateMktDepthL2(int i, int i1, String s, int i2, int i3, double v, int i4) {

    }

    @Override
    public void updateNewsBulletin(int i, int i1, String s, String s1) {

    }

    @Override
    public void managedAccounts(String s) {

    }

    @Override
    public void receiveFA(int i, String s) {

    }

    @Override
    public void historicalData(int i, String s, double v, double v1, double v2, double v3, int i1, int i2, double v4, boolean b) {

    }

    @Override
    public void scannerParameters(String s) {

    }

    @Override
    public void scannerData(int i, int i1, ContractDetails contractDetails, String s, String s1, String s2, String s3) {

    }

    @Override
    public void scannerDataEnd(int i) {

    }

    @Override
    public void realtimeBar(int i, long l, double v, double v1, double v2, double v3, long l1, double v4, int i1) {

    }

    @Override
    public void currentTime(long l) {

    }

    @Override
    public void fundamentalData(int i, String s) {

    }

    @Override
    public void deltaNeutralValidation(int i, DeltaNeutralContract deltaNeutralContract) {

    }

    @Override
    public void tickSnapshotEnd(int i) {

    }

    @Override
    public void marketDataType(int i, int i1) {

    }

    @Override
    public void commissionReport(CommissionReport commissionReport) {

    }

    @Override
    public void position(String s, Contract contract, double v, double v1) {

    }

    @Override
    public void positionEnd() {

    }

    @Override
    public void accountSummary(int i, String s, String s1, String s2, String s3) {

    }

    @Override
    public void accountSummaryEnd(int i) {

    }

    @Override
    public void verifyMessageAPI(String s) {

    }

    @Override
    public void verifyCompleted(boolean b, String s) {

    }

    @Override
    public void verifyAndAuthMessageAPI(String s, String s1) {

    }

    @Override
    public void verifyAndAuthCompleted(boolean b, String s) {

    }

    @Override
    public void displayGroupList(int i, String s) {

    }

    @Override
    public void displayGroupUpdated(int i, String s) {

    }

    @Override
    public void error(Exception e) {
        if (clientSocket.isConnected()) {
            System.out.println("Connect Error");
        }
    }

    @Override
    public void error(String s) {

    }

    @Override
    public void error(int i, int i1, String s) {

    }

    @Override
    public void connectionClosed() {

    }

    @Override
    public void connectAck() {
        System.out.println("连接成功！");

    }

    @Override
    public void positionMulti(int i, String s, String s1, Contract contract, double v, double v1) {

    }

    @Override
    public void positionMultiEnd(int i) {

    }

    @Override
    public void accountUpdateMulti(int i, String s, String s1, String s2, String s3, String s4) {

    }

    @Override
    public void accountUpdateMultiEnd(int i) {

    }

    @Override
    public void securityDefinitionOptionalParameter(int i, String s, int i1, String s1, String s2, Set<String> set, Set<Double> set1) {

    }

    @Override
    public void securityDefinitionOptionalParameterEnd(int i) {

    }

    @Override
    public void softDollarTiers(int i, SoftDollarTier[] softDollarTiers) {

    }
}
