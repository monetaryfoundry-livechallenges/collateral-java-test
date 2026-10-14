package com.heldnav.risk;

public record BorrowRequest(
        long collateralValue,
        long existingDebt,
        long additionalBorrow,
        int maxLtvBps) {
}
