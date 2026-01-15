package ru.alfastrah.agentplatform.serviceautotests.api.tests;

import io.qameta.allure.AllureId;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.apache.hc.core5.http.HttpStatus;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ru.alfastrah.agentplatform.serviceautotests.api.clients.shell.TabControllerClient;
import ru.alfastrah.agentplatform.serviceautotests.api.models.TabRequest;
import ru.alfastrah.agentplatform.serviceautotests.api.requests.CreateTabRequestBuilder;
import ru.alfastrah.agentplatform.serviceautotests.api.response.CreateTabResponse;
import ru.alfastrah.agentplatform.serviceautotests.api.response.TabResponse;

import java.util.Arrays;
import java.util.List;

import static ru.alfastrah.agentplatform.serviceautotests.api.assertions.Conditions.hasStatusCode;

@Epic("Вкладки")
@Feature("API")
@Story("CreateTabTests")
@Tag("API")
public class CreateTabTests {
    private TabControllerClient tabControllerClient;

    @BeforeEach
    public void setUp() {
        tabControllerClient = new TabControllerClient();
    }

    @Test
    @AllureId("TAB-01")
    @DisplayName("Создание вкладки, проверка в списке и удаление")
    public void createTabAndVerifyInList() {
        TabRequest request = CreateTabRequestBuilder.buildDefaultTabRequest();

        CreateTabResponse createResponse = tabControllerClient.createTab(request)
                .should(hasStatusCode(HttpStatus.SC_CREATED))
                .as(CreateTabResponse.class);

        Assertions.assertNotNull(createResponse.getId(), "id вкладки не должен быть null");
        Assertions.assertNotNull(createResponse.getTitle(), "title вкладки не должен быть null");
        Assertions.assertNotNull(createResponse.getPath(), "path вкладки не должен быть null");
        Assertions.assertFalse(createResponse.getTitle().isBlank(), "title вкладки не должен быть пустым");
        Assertions.assertFalse(createResponse.getPath().isBlank(), "path вкладки не должен быть пустым");

        List<TabResponse> tabs = Arrays.asList(
                tabControllerClient.getTabs()
                        .should(hasStatusCode(HttpStatus.SC_OK))
                        .as(TabResponse[].class)
        );

        TabResponse createdTab = tabs.stream()
                .filter(tab -> createResponse.getId().equals(tab.getId()))
                .findFirst()
                .orElseThrow(() -> new AssertionError("Вкладка с id не найдена в списке пользователя"));

        Assertions.assertNotNull(createdTab.getId(), "id вкладки не должен быть null");
        Assertions.assertEquals(createResponse.getId(), createdTab.getId(), "id вкладки должен совпадать");
        Assertions.assertNotNull(createdTab.getTitle(), "title вкладки не должен быть null");
        Assertions.assertNotNull(createdTab.getPath(), "path вкладки не должен быть null");
        Assertions.assertFalse(createdTab.getTitle().isBlank(), "title вкладки не должен быть пустым");
        Assertions.assertFalse(createdTab.getPath().isBlank(), "path вкладки не должен быть пустым");

        tabControllerClient.deleteTab(createResponse.getId())
                .should(hasStatusCode(HttpStatus.SC_OK));
    }
}
