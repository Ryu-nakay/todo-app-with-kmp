//
//  TodoViewModel.swift
//  iosApp
//
//  Created by cw-ryu.nakayama on 2023/08/29.
//  Copyright © 2023 orgName. All rights reserved.
//

import Foundation
import shared

class TodoViewModel: ObservableObject {
    @Published var inputContent = ""
    @Published var todoItemList = TodoItemList.companion.createEmpty()

    func onTapAddButton() {
        todoItemList = todoItemList.addNewItem(name: inputContent)
        inputContent = ""
    }
}
