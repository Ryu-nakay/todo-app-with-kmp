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
    @Published var todoItemList = TodoItemList.companion.createEmpty()

    init() {
        todoItemList = todoItemList.addNewItem(name: "1つ目")
        todoItemList = todoItemList.addNewItem(name: "2つ目")
    }

    func onTapAddButton() {
        todoItemList = todoItemList.addNewItem(name: "追加分")
        print(todoItemList.items.size)
    }
}
