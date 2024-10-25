//
//  NewsViewModel.swift
//  iosNewsApp
//
//  Created by Wildan Nafian on 10/17/24.
//  Copyright © 2024 orgName. All rights reserved.
//

import Foundation
import shared

class NewsViewModel: ObservableObject {

    private let repository = DependencyHelper().repository

    @Published var newsData: [NewsItem] = [NewsItem]()
    @Published var isAlertDisplayed = false
    @Published var isLoading = false
    @Published var onError: String? = nil

    func getNewsData() async {
        updateLoadingState(state: true)
        for await result in repository.getLatestTechNews() {
            result.handleData(
                onSuccess: { data in
                    DispatchQueue.main.async {
                        self.newsData = data
                    }
                }, onError: { message in
                    DispatchQueue.main.async {
                        self.onError = message
                        self.isAlertDisplayed = true
                    }
                }
            )
        }
        updateLoadingState(state: false)
    }

    private func updateLoadingState(state: Bool) {
        DispatchQueue.main.async {
            self.isLoading = state
        }
    }

}
